package njuics.demos.pipefilter;

import org.springframework.batch.item.ItemWriter;
import java.util.List;
import java.io.*;

public class MyWriter implements ItemWriter<Report> {

    @Override
    public void write(List <? extends Report> list) throws IOException {
        //Stream re = new Stream();
        File file = new File("xml/outputs/result");
        FileWriter fileWriter = new FileWriter(file);
        try {
            System.out.print(list.size());
            for (int i = 0; i < list.size(); i++) {
                Report report = list.get(i);
                fileWriter.write(report.toString());
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
    }
}