package workshop.bin.workshop;

class HistoryManager{
    private String[] history=new String[20];
    private int currentPage=-1;
    private int lastPage=-1;

public void visit(String url){
    currentPage++;
    history[currentPage]=url;
    lastPage=currentPage;
    System.out.println("visit"+url);
}
public void back(){
    if(currentPage>0){
        currentPage--;
        System.out.println("Back to"+history[currentPage]);
    }
    else {
        System.out.println("No more history to back");
    }
}
public void forward(){
    if(currentPage<lastPage){
        currentPage++;
        System.out.println("forward to" +history[currentPage]);
    }
    else{
        System.out.println("no more history to forward");
    }
}
public void currentPage(){
    if(currentPage>=0){
        System.out.println("current page is"+history[currentPage]);
    }
    else{
        System.out.println("No more current page");
    }
}
}


public class BrowserHistory {
    public static void main(String[] args){
        HistoryManager browser=new HistoryManager();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("yahoo.com");
        browser.visit("facebook.com");


        browser.back();
        browser.currentPage();

        browser.forward();
        browser.currentPage();
        }
    
}
