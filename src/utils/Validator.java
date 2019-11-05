package utils;

import java.util.HashMap;

/**
 * @author tranphuquy19@gmail.com
 * @since 05/11/2019
 */
public class Validator {
    private HashMap<String, Message> validator = new HashMap<>();
    private boolean isOK = true;

    public Validator() {
    }

    /**
     * @param key          Trường name của input
     * @param currentValue Giá trị khi submit
     * @param isValid      Hợp lệ
     * @param mess         Thông báo lên View
     */
    public void put(String key, Object currentValue, boolean isValid, String mess) {
        if (!isValid) this.isOK = false;
        validator.put(key, new Message(currentValue, isValid, mess));
    }

    public void update(String key, Object currentValue, boolean isValid, String mess) {
        if (!isValid) this.isOK = false;
        Message mss = validator.replace(key, new Message(currentValue, isValid, mess));
    }

    public Object getCurrentValue(String key) {
        if (validator.containsKey(key))
            return validator.get(key).currentValue;
        else return " ";
    }

    public String getFeedbackHTML(String key) {
        if (validator.containsKey(key)) {
            Message m = validator.get(key);
            String mess = "<div class=\"";
            if (m.isValid)
                mess += "valid";
            else mess += "invalid";
            mess += "-feedback\">" + (m.mess == null ? "" : m.mess) + "</div>";
            return mess;
        } else return " ";
    }

    public String is(String key) {
        if (validator.containsKey(key))
            return validator.get(key).isValid ? "is-valid" : "is-invalid";
        else return " ";
    }

    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }

    @Override
    public String toString() {
        return "Validator{" +
                "validator=" + validator +
                ", isOK=" + isOK +
                '}';
    }

    /**
     * Message của validator
     */
    private class Message {
        private Object currentValue;
        private boolean isValid;
        private String mess;

        public Message(Object currentValue, boolean isValid, String mess) {
            this.currentValue = currentValue;
            this.isValid = isValid;
            this.mess = mess;
        }
    }
}
