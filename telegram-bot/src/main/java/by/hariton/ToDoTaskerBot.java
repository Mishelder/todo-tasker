package by.hariton;

import by.miaskor.domain.connector.ClientConnector;
import by.miaskor.domain.connector.TaskConnector;
import by.miaskor.domain.dto.TaskDtoResponse;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class ToDoTaskerBot extends TelegramLongPollingBot {

    private final ClientConnector clientConnector;
    private final TaskConnector taskConnector;

    protected ToDoTaskerBot(DefaultBotOptions options) {
        super(options);
        clientConnector = new ConnectorsConfig().clientConnector();
        taskConnector = new ConnectorsConfig().taskConnector();
    }

    public String getBotUsername() {
        return "@ToDoTaskerBot";
    }

    public String getBotToken() {
        return "5042012734:AAEoCC7pfoU0uW0GikAomW9jI_j6VbkIDPQ";
    }

    public static void main(String[] args) throws TelegramApiException {
        ToDoTaskerBot bot = new ToDoTaskerBot(new DefaultBotOptions());
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleMessage(Message message) throws TelegramApiException {
        if (message.hasText()) {
            Long botId = message.getChatId();
            if (message.hasEntities()) {
                Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
                if (commandEntity.isPresent()) {
                    String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                    switch (command) {
                        case "/start":
                            execute(SendMessage.builder().text("Ваш уникальный id - " + botId.toString()).chatId(
                                botId.toString()).build());
                            break;
                        case "/today":
                            List<TaskDtoResponse> taskList = taskConnector.getTasksOnCurrentDayByBotId(botId);
                            for (TaskDtoResponse task : taskList) {
                                execute(
                                    SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                            }
                            break;
                        case "/tomorrow":
                            execute(SendMessage.builder().text(" tomorrow").chatId(botId.toString()).build());
                            break;
                        case "/Failed":
                            execute(SendMessage.builder().text(" failed").chatId(botId.toString()).build());
                            break;
                        case "/UPCOMING":
                            execute(SendMessage.builder().text(" upc").chatId(botId.toString()).build());
                            break;
                        case "/COMPLETED":
                            execute(SendMessage.builder().text(" comp").chatId(botId.toString()).build());
                            break;
                        case "/IN_PROCESS":
                            execute(SendMessage.builder().text(" in").chatId(botId.toString()).build());
                            break;
                    }
                }
            } else {
                try {
                    LocalDate.parse(message.getText());
                    execute(SendMessage.builder().text("2021-01-01").chatId(botId.toString()).build());
                } catch (DateTimeParseException ex) {
                    execute(
                        SendMessage.builder().text("Введите дату в правильном формате. \n Например: 2021-01-01").chatId(
                            botId.toString()).build());
                }
            }
        }
    }
}
