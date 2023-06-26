package dataprovider;

import models.UserModel;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderForLogin {

    @DataProvider
    public Iterator<Object[]> DpFile_loginPositiveTest() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(
                "src/test/resources/dataForLogin/data_LoginPositiveTest.csv")));
        String line = reader.readLine();
        while (line!=null){
            String split[] = line.split(",");
            list.add(new Object[]{UserModel.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
