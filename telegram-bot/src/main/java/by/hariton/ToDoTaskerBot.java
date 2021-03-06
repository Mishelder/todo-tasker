package by.hariton;

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

    private final TaskConnector taskConnector;

    protected ToDoTaskerBot(DefaultBotOptions options) {
        super(options);
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
            List<TaskDtoResponse> taskList;
            if (message.hasEntities()) {
                Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
                if (commandEntity.isPresent()) {
                    String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                    switch (command) {
                        case "/start":
                            execute(SendMessage.builder().text("?????? ???????????????????? id - " + botId.toString() +
                                    ".\n?????????? ?????? ???????????????????? ???? ???????? ??????????????????, ?????????????? ?????? ???? ??????????, ?? " +
                                    "?????????????? Profile -> BotId.\n?????? ???? ???? ???????????? " +
                                    "???????????????????????? ???????????? ?????????????????? ?????? ???????????? ?????????? ????????,?? ?????????????? 2021-01-01," +
                                    " ?????????? ???????????? ???????? ?????????? ???? ???????? ????????.").chatId(
                                botId.toString()).build());
                            break;
                        case "/today":
                            taskList = taskConnector.getTasksOnCurrentDayByBotId(botId);
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? ???? ?????????????? ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? ???? ??????????????:\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                        case "/tomorrow":
                            taskList = taskConnector.getTasksOnTomorrowByBotId(botId);
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? ???? ???????????? ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? ???? ????????????:\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                        case "/failed":
                            taskList = taskConnector.getAllByBotIdAndState(botId,message.getText().substring(1));
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? c?? ???????????????? \"failed\" ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? c?? ???????????????? \"failed\":\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                        case "/upcoming":

                            taskList = taskConnector.getAllByBotIdAndState(botId,message.getText().substring(1));
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? c?? ???????????????? \"upcoming\" ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? c?? ???????????????? \"upcoming\":\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                        case "/completed":
                            taskList = taskConnector.getAllByBotIdAndState(botId,message.getText().substring(1));
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? c?? ???????????????? \"completed\" ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? c?? ???????????????? \"completed\":\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                        case "/in_process":
                            taskList = taskConnector.getAllByBotIdAndState(botId,message.getText().substring(1));
                            if (taskList.isEmpty()){
                                execute(
                                        SendMessage.builder().text("????????????????, ?????????? c?? ???????????????? \"in_process\" ??????").chatId(botId.toString()).build());
                            }else {
                                execute(
                                        SendMessage.builder().text("???????????? c?? ???????????????? \"in_process\":\n").chatId(botId.toString()).build());
                                for (TaskDtoResponse task : taskList) {
                                    execute(
                                            SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                                }
                            }
                            break;
                    }
                }
            } else {
                try {
                    LocalDate.parse(message.getText());
                    taskList = taskConnector.getAllByBotIdAndDate(botId,message.getText());
                    if (taskList.isEmpty()){
                        execute(
                                SendMessage.builder().text("????????????????, ?????????? ???? " + message.getText() + " ??????")
                                        .chatId(botId.toString()).build());
                    }else {
                        execute(
                                SendMessage.builder().text("???????????? ???? " + message.getText() + ":\n").chatId(botId.toString()).build());
                        for (TaskDtoResponse task : taskList) {
                            execute(
                                    SendMessage.builder().text(task.getTaskName()).chatId(botId.toString()).build());
                        }
                    }
                } catch (DateTimeParseException ex) {
                    execute(
                        SendMessage.builder().text("?????????????? ???????? ?? ???????????????????? ??????????????. \n ????????????????: 2021-01-01").chatId(
                            botId.toString()).build());
                }
            }
        }
    }
}
