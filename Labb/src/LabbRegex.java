import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabbRegex {

    public static void main(String[] args) {

       String myString1 = "System.out.println( hello33!+ 22 );";
       String myString2 = "if(ab1<=22Bc) { w } else ";
       String myString3 = "for(i=56; i<=h; i++ ) { hello! }";
       String myString4 = "while()";


        String pattern_SysOut = "System\\.out\\.println\\(+(\\s+)?+(([a-zA-Z0-9]+)|([a-zA-Z0-9]+[\\W]+)|(\"[A-Za-z0-9]+[\\W]\"+))?[\\+](\\s+)?([a-zA-Z0-9]+)?(\\s+)?+\\);";
        String pattern_If = "if\\((\\s+)?([a-zA-Z0-9]+)?(\\>|\\<|\\=|\\<+\\=|\\>+\\=)?([a-zA-Z0-9]+)?(\\s+)?\\)(\\s+)?\\{(\\s+)?([\\w]+)?([\\W]+)?\\}(\\s+)?((elseif)|(else))?";
        String pattern_For = "for\\((\\s+)?([a-zA-Z0-9]+)?(\\=)?([a-zA-Z0-9]+)?(\\s+)?(\\;)?(\\s+)?([a-zA-Z0-9]+)?((\\=)|(\\<)|(\\>)|(\\<+\\=)|(\\>+\\=))?(\\s+)?([a-zA-Z0-9]+)?(\\;)?(\\s+)?([a-zA-Z0-9]+)?((\\++\\+)|(\\-+\\-))?(\\s+)\\)(\\s+)(\\{)?(\\s+)?([\\w]+)?([\\W]+)?(\\s+)\\}?";
        String pattern_While = "while+\\(*([a-z]\\w*)*((?:!=|[=<>]=?))*([a-z]\\w*|\\d+)*\\)";


        finder(myString1, pattern_SysOut);


            }

            public static void finder( String myString, String pattern){
                Pattern p = Pattern.compile(pattern);
                Matcher matcher = p.matcher(myString);
                while(matcher.find()){
                    if(matcher.group().length()!=0) {
                        System.out.println(matcher.group());
                    }
                    System.out.println("Start: " +matcher.start()+"");
                    System.out.println("End: " +matcher.end()+"");
                }

            }




    }


