package com.example.irregularverbs;

public class AllVerbDataBase {
    private String [] data;
    public AllVerbDataBase(){
    fillData();
    }
    private void fillData(){
        this.data= new String[]{
                "arise,arose,arisen",
                "awake,awoke,awoken",
                "be,was/were,been",
                "bear,bore,borne/born",
                "beat,beat,beaten",
                "become,became,become",
                "begin,began,begun",
                "bend,bent,bent",
                "bet,bet,bet",
                "bite,bit,bitten",
                "blow,blew,blown",
                "break,broke,broken",
                "bring,brought,brought",
                "build,built,built",
                "burn,burnt,burnt",
                "burst,burst,burst",
                "buy,bought,bought",
                "catch,caught,caught",
                "choose,chose,chosen",
                "come,came,come",
                "cost,cost,cost",
                "cut,cut,cut",
                "dig,dug,dug",
                "do,did,done",
                "draw,drew,drawn",
                "drink,drank,drunk",
                "drive,drove,driven",
                "eat,ate,eaten",
                "fall,fell,fallen",
                "feed,fed,fed",
                "feel,felt,felt",
                "fight,fought,fought",
                "find,found,found",
                "fly,flew,flown",
                "forget,forgot,forgotten",
                "forgive,forgave,forgiven",
                "freeze,froze,frozen",
                "go,went,gone",
                "give,gave,given",
                "get,got,got/gotten",
                "grow,grew,grown",
                "hang,hung,hung",
                "have,had,had",
                "hear,heard,heard",
                "hide,hid,hidden",
                "hit,hit,hit",
                "hold,held,held",
                "hurt,hurt,hurt",
                "keep,kept,kept",
                "know,knew,known",
                "lay,laid,laid",
                "lead,led,led",
                "learn,learnt/learned,learnt/learned",
                "leave,left,left",
                "lend,lent,lent",
                "let,let,let",
                "lie,lay,lain",
                "light,lit/lighted,lit/lighted",
                "lose,lost,lost",
                "make,made,made",
                "mean,meant,meant",
                "meet,met,met",
                "pay,paid,paid",
                "put,put,put",
                "read,read,read",
                "ride,rode,ridden",
                "ring,rang,rung",
                "rise,rose,risen",
                "run,ran,run",
                "say,said,said",
                "see,saw,seen",
                "seek,sought,sought",
                "sell,sold,sold",
                "send,sent,sent",
                "set,set,set",
                "shake,shook,shaken",
                "shine,shone,shone",
                "shoot,shot,shot",
                "show,showed,shown",
                "shrink,shrank,shrunk",
                "shut,shut,shut",
                "sing,sang,sung",
                "sink,sank,sunk",
                "sit,sat,sat",
                "sleep,slept,slept",
                "slide,slid,slid",
                "speak,spoke,spoken",
                "spend,spent,spent",
                "spin,spun,spun",
                "spread,spread,spread",
                "stand,stood,stood",
                "steal,stole,stolen",
                "stick,stuck,stuck",
                "sting,stung,stung",
                "stink,stank,stunk",
                "strike,struck,struck/stricken",
                "swear,swore,sworn",
                "sweep,swept,swept",
                "swim,swam,swum",
                "swing,swung,swung",
                "take,took,taken",
                "teach,taught,taught",
                "tear,tore,torn",
                "tell,told,told",
                "think,thought,thought",
                "throw,threw,thrown",
                "understand,understood,understood",
                "wake,woke,woken",
                "wear,wore,worn",
                "weep,wept,wept",
                "win,won,won",
                "write,wrote,written"
        };

    }
    public String getLine(String words){
        for (String datum : data) {
            if (datum.contains(words+",")||datum.contains(","+words+",")||
                    datum.contains(","+words)||datum.contains(","+words+"/")||datum.contains("/"+words+",")) {
                return datum;
            }
        }
         return null;
    }
    public String getLineSpace(String words){
        for (String datum : data) {
            if (datum.contains(words+",")||datum.contains(","+words+",")||
                    datum.contains(","+words)||datum.contains(","+words+"/")||datum.contains("/"+words+",")) {
                String [] space=datum.split(",");
                return "Verb: "+space[0]+"  Past Simple: "+space[1]+"  Past Participle: "+space[2];
            }
        }
        return null;
    }
    public String [] getData(){
        return data;
    }
    public String [] getEditData(){
        String editData []=new String[data.length+1];
        editData[0]="Verb        Past Simple        Past Participle";
        for (int i =1;i<=data.length;i++) {
            String [] splitString=data[i-1].split(",");
            editData[i]=splitString[0]+"      "+splitString[1]+"   "+splitString[2];
        }
        return editData;
    }
    public int getSize(){
        return data.length;
    }
    public String getLineData(int index){
        return data[index];
    }
    public String[] getThreeVerb(int index){
        return data[index].split(",");
    }
    public String[] getTwoVerb(String verb){
       String line= getLine(verb);
       return line.split(",");
    }
}
