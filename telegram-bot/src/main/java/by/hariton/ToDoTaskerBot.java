package by.hariton;

import by.miaskor.domain.connector.ClientConnector;
import by.miaskor.domain.connector.TaskConnector;
import by.miaskor.domain.dto.ClientDtoResponse;
import by.miaskor.domain.dto.TaskDtoResponse;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

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
            if (message.hasEntities()) {
                Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
                if (commandEntity.isPresent()) {
                    String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                    switch (command) {
                        case "/start":
                            execute(SendMessage.builder().text("Ваш уникальный id - " + message.getChatId().toString()).chatId(message.getChatId().toString()).build());
                            return;
                        case "/today":
                            List<TaskDtoResponse> taskList = taskConnector.getTasksOnCurrentDayByBotId(Integer.parseInt(message.getChatId().toString()));
                            for (TaskDtoResponse task : taskList) {
                                execute(SendMessage.builder().text(task.getTaskName()).chatId(message.getChatId().toString()).build());
                            }
                            return;
                        case "/tomorrow":
                            execute(SendMessage.builder().text(" tomorrow").chatId(message.getChatId().toString()).build());
                            return;
                        case "/Failed":
                            execute(SendMessage.builder().text(" failed").chatId(message.getChatId().toString()).build());
                            return;
                        case "/UPCOMING":
                            execute(SendMessage.builder().text(" upc").chatId(message.getChatId().toString()).build());
                            return;
                        case "/COMPLETED":
                            execute(SendMessage.builder().text(" comp").chatId(message.getChatId().toString()).build());
                            return;
                        case "/IN_PROCESS":
                            execute(SendMessage.builder().text(" in").chatId(message.getChatId().toString()).build());
                            return;
                    }
                }
            } else {
                try {
                    LocalDate.parse(message.getText());
                    execute(SendMessage.builder().text("2021-01-01").chatId(message.getChatId().toString()).build());
                } catch (DateTimeParseException ex){
                    execute(SendMessage.builder().text("Введите дату в правильном формате. \n Например: 2021-01-01").chatId(message.getChatId().toString()).build());
                }
            }
        }
    }
}
