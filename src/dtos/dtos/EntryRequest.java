package dtos;

public class EntryRequest{
    private String userName;
    private String title;
    private String body;
    private int id;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getBody(){
        return body;
    }

    public int getId(){
        return id;
    }

    private void setId(int id){
        this.id=id;
    }

    public void setAuthour(String userName){
        this.userName=userName;
    }

    public void setbody(String body){
        this.body=body;
    }
}
