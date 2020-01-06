package cn.book.bus.dto;

/**
 * 服务层参数
 */
public class FictionDto {

    private String type;

    private String state;
    private String fiction_name;

    public String getFiction_name() {
        return fiction_name;
    }
    public void setFiction_name(String fiction_name) {
        this.fiction_name = fiction_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
