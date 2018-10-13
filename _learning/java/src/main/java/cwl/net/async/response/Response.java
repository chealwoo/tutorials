package cwl.net.async.response;

public class Response {


    private Boolean success;

    private java.lang.Error error;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public java.lang.Error getError() {
        return error;
    }

    public void setError(java.lang.Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", error=" + error +
                '}';
    }
}
