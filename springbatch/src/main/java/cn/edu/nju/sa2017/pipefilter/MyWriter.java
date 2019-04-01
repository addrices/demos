package cn.edu.nju.sa2017.pipefilter;

import org.springframework.batch.item.ItemWriter;
import java.util.List;
import java.io.*;

public class MyWriter implements ItemWriter<Report> {

    @Override
    public void write(List <? extends Report> list) throws IOException {
        File file = new File("xml/outputs/result");
        FileWriter fileWriter = new FileWriter(file);
        try {
            System.out.print(list.size());
            System.out.println("listsize!\n");
            fileWriter.write("{\nReport:[\n");
            for (int i = 0; i < list.size(); i++) {
                Report report = list.get(i);
                fileWriter.write(report.toJson());
                if(i != list.size()-1)
                    fileWriter.write(",\n");
                else
                    fileWriter.write("\n");
                fileWriter.flush();
            }
            fileWriter.write("]\n}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
    }
}