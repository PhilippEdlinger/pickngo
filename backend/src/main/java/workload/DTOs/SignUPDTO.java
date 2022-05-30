package workload.DTOs;

import java.util.HashMap;

public class SignUPDTO {
    private boolean success;
    private HashMap<String, String> msgs;

    public SignUPDTO() {
    }

    public SignUPDTO(boolean success, HashMap<String, String> msgs) {
        this.success = success;
        this.msgs = msgs;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HashMap<String, String> getMsgs() {
        return msgs;
    }

    public void setMsgs(HashMap<String, String> msgs) {
        this.msgs = msgs;
    }
}
