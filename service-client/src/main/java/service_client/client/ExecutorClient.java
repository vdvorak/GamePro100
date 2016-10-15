package service_client.client;

import service_client.data.request.SubmitRequest;
import service_client.data.TaskResult;
import service_client.result.TaskResultResponse;

public class ExecutorClient extends Client {
    private static final String SERVICE_PATH = "/task-executor-service";

    ExecutorClient() {
        super(SERVICE_PATH);
    }

    public TaskResult submit(final SubmitRequest request) {
        return post("/submit", request, TaskResultResponse.class).getData();
    }
}