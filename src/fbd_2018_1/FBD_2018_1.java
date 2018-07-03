package fbd_2018_1;

import br.com.fbd_2018_1.business.BusinessAluno;
import br.com.fbd_2018_1.business.BusinessCurso;
import br.com.fbd_2018_1.business.IBusinessAluno;
import br.com.fbd_2018_1.business.IBusinessCurso;
import br.com.fbd_2018_1.entidade.*;
import br.com.fbd_2018_1.entidade.enums.Sexo;
import br.com.fbd_2018_1.entidade.enums.TipoContato;
import br.com.fbd_2018_1.exceptions.BusinessException;
import br.com.fbd_2018_1.fachada.Fachada;
import br.com.fbd_2018_1.fachada.IFachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FBD_2018_1 {

    static IFachada fachada = Fachada.getInstance();

    public static void main(String[] args) {

        try {

//            addAlunos();
            Aluno a = fachada.buscarAlunoPorCpf("05014028454");
            
            a.setNome("heldon jose oliveira albuquerque");
//            fachada.salvarOuEditarAluno(a);
            
            
            
            System.out.println(a);
            System.out.println(a.getEndereco().getId());

            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    public static void addAlunos() {
        Aluno a = new Aluno();
        a.setNome("HELDON JOSE");
        a.setCpf("05014028454");
        a.setSexo(Sexo.MASCULINO);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1984);
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DAY_OF_MONTH, 17);
        a.setDataNascimento(c.getTime());

        Endereco e = new Endereco();
        e.setRua("Capitaão Crisanto");
        e.setNumero("42");
        e.setBairro("Santo Antônio");
        e.setCidade("PATOS");
        e.setEstado("PB");

        a.setEndereco(e);

        List<Contato> contatos = new ArrayList<>();
        Contato c1 = new Contato();
        c1.setTipoContato(TipoContato.EMAIL);
        c1.setDescricao("heldonjose@gmail.com");
        contatos.add(c1);
        c1 = new Contato();
        c1.setTipoContato(TipoContato.TELEFONE);
        c1.setDescricao("(83)-9-9627-9632");
        contatos.add(c1);

        a.setContatos(contatos);

        try {
            fachada.salvarOuEditarAluno(a);
        } catch (BusinessException ex) {
            Logger.getLogger(FBD_2018_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
