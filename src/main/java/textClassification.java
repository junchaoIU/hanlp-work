import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class textClassification {

    public static void main(String[] args) throws IOException {
        int count = 1;
       File file = new File("result.txt");
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)))){
            StringBuffer stringBuffer = new StringBuffer();
            try{
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("D:\\HanlpWork\\src\\main\\resources\\sentences.txt")));
                String linestr;
                while((linestr = br.readLine()) != null){
                    //标准分词
                    List<Term> termList = StandardTokenizer.segment(linestr);
                    List<String> item = new ArrayList();
                    for(Term term: termList){
                        item.add(term.word);
                    }
                    System.out.println("第"+ count +"行："+ linestr +"分词完毕");
                    count+=1;
                    System.out.println(item);
                        stringBuffer.append(item);
                        stringBuffer.append("\n");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            bw.write(stringBuffer.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
