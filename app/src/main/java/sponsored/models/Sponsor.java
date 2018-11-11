package sponsored.models;

public class Sponsor {
    private int id;
    private int logo;
    private String title;
    private String description;
    private Long amountDonate;

    public Sponsor(int id, int logo, String title, String description, Long amountDonate) {
        this.id = id;
        this.logo = logo;
        this.title = title;
        this.description = description;
        this.amountDonate = amountDonate;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmountDonate() {
        return amountDonate;
    }

    public void setAmountDonate(Long amountDonate) {
        this.amountDonate = amountDonate;
    }

}