/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.business;

import br.com.fbd_2018_1.entidade.Aluno;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IBusinessAluno {
    
    public void salvarOuEditar(Aluno aluno);
    public Aluno buscarPorId(int id);
    public Aluno buscarPorCpf(String cpf);
    public List<Aluno> buscarPorBusca(String busca);
    
}
