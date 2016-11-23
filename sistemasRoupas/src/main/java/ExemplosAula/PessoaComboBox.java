/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author junior
 * References: http://pt.stackoverflow.com/questions/105695/preencher-jcombobox-com-um-objeto
 */
public  class PessoaComboBox extends AbstractListModel<Pessoa> implements ComboBoxModel<Pessoa>{

    private List<Pessoa> list;
    private Pessoa pessoaSelect;
    
    public PessoaComboBox(){
        fillField();
        setSelectedItem(list.get(0));
    }
    
    public int getSize() {
        return list.size();
    }

    public Pessoa getElementAt(int index) {
        Pessoa pessoa = list.get(index);
        return pessoa;
    }

    public void setSelectedItem(Object anItem) {
         this.pessoaSelect = (Pessoa)anItem;
    }

    public Object getSelectedItem() {
        return this.pessoaSelect;
    }
    
    public void fillField(){
        
        this.list.add(new Pessoa("Mariana","000.000.000-00",25,"Rua das Moçoes"));
        this.list.add(new Pessoa("Carla","111.111.111-11",30,"Rua das Antenas"));
        this.list.add(new Pessoa("Solange","222.222.222-22",40,"Rua Antares"));
        this.list.add(new Pessoa("Dayane","333.333.333-33",50,"Rua Capao ceco"));
        
    }
    
}
