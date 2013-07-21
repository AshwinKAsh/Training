

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaValidLines 
{
  public static void main(String[] args) {
    int lines = new JavaValidLines().doubleSlash();
    System.out.println("Total Lines Valid java lines : "+ lines );
  }

  public int doubleSlash() {
	  
    String doubleSlashRegex = "/{2}+";
    String doubleSlashValidLineRegex = "[);{}][\\s]*[/]{2}+";
    String blockCommentStartsRegex = "[/]{1}[*]{1}";
    String blockCommentEndsRegex = "[*]{1}[/]{1}";
    String blockCommentRegex = "([/]+[*]+.+[*]+[/]+)|([/]+[*]+[*]+[/]+)";
    
    int emptyLine=0;
    int noOfLines= 0;
    int doubleSlash=0;
    int doubleSlashValidLine=0;
    int blockComments=0;
    int blockCommentStarts=0;
    int blockCommentEnds=0;
    int blockComment = 0;

    BufferedReader br = null;
    try {
      String sCurrentLine;

      br = new BufferedReader(new FileReader("D:\\No2.java"));

      while ((sCurrentLine = br.readLine()) != null) {
        	noOfLines++;
        Pattern doubleSlashPattern = Pattern.compile(doubleSlashRegex);
        Matcher doubleSlashMatcher = doubleSlashPattern.matcher(sCurrentLine);
        
        Pattern doubleSlashValidLinePattern = Pattern.compile(doubleSlashValidLineRegex);
        Matcher doubleSlashValidLineMatcher = doubleSlashValidLinePattern.matcher(sCurrentLine);
        
        Pattern blockCommentStartsPattern = Pattern.compile(blockCommentStartsRegex);
        Matcher blockCommentStartsMatcher = blockCommentStartsPattern.matcher(sCurrentLine);
        
        Pattern blockCommentEndsPattern = Pattern.compile(blockCommentEndsRegex);
        Matcher blockCommentEndsMatcher = blockCommentEndsPattern.matcher(sCurrentLine);
        
        Pattern blockCommentPattern = Pattern.compile(blockCommentRegex);
        Matcher blockCommentMatcher = blockCommentPattern.matcher(sCurrentLine);
        
        
        if(sCurrentLine.trim().isEmpty())
        	emptyLine++;
        if(blockCommentMatcher.find())
        {
        	sCurrentLine=sCurrentLine.replaceAll(blockCommentRegex," ");
            if(sCurrentLine.trim().isEmpty()){}
            else blockComment++;
        }
        if (doubleSlashMatcher.find()) 
        	doubleSlash++;
        if (doubleSlashValidLineMatcher.find()) 
        	doubleSlashValidLine++;
        if (blockCommentStartsMatcher.find())
        	blockCommentStarts=blockCommentStarts+noOfLines;
        if (blockCommentEndsMatcher.find())
        	blockCommentEnds=blockCommentEnds+noOfLines+1;
        blockComments=blockCommentEnds-blockCommentStarts-blockComment;
      }
      
      System.out.println("Total no of lines :"+noOfLines);
      System.out.println("Total no of empty lines : "+emptyLine);
      System.out.println("Total no of lines containing doubleSlash :"+doubleSlash);
      System.out.println("Total no of lines containing doubleSlashValidLine :"+doubleSlashValidLine);
      System.out.println("Total no of lines containing Block Comments : "+blockComments +" "+blockComment);
   
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return noOfLines-emptyLine-doubleSlash+doubleSlashValidLine-blockComments;
  }
}