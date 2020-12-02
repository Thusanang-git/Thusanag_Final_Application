package com.example.thusaappbathopele;

public class uploadPDF {
    public String filename;
    public String url;

    public uploadPDF(){

    }

    public uploadPDF(String name, String url){
        this.filename = name;
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getUrl(){
        return url;

    }

    public void setUrl(String url) {
        this.url = url;
    }

}
