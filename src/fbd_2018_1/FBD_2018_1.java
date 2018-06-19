package fbd_2018_1;

import br.com.fbd_2018_1.business.BusinessAluno;
import br.com.fbd_2018_1.business.BusinessCurso;
import br.com.fbd_2018_1.business.IBusinessAluno;
import br.com.fbd_2018_1.business.IBusinessCurso;
import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.fachada.Fachada;
import br.com.fbd_2018_1.fachada.IFachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FBD_2018_1 {

    public static void main(String[] args) {

        try {

            IFachada fachada = Fachada.getInstance();

            Curso c = fachada.buscarCursoPorId(10);

            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

}
