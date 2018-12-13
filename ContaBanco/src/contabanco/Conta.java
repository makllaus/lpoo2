/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabanco;

/**
 *
 * @author tone
 */
public class Conta {

    //Atributos
    public Integer numConta;
    protected String tipo;
    private String nomeTitular;
    private float saldo;
    private boolean status;

    //métodos personalizados
    public void status() {
        System.out.println("\nConta: " + this.getNumConta());
        System.out.println("\nTipo: " + this.getTipo());
        System.out.println("\nTitular: " + this.getNomeTitular());
        System.out.println("\nSaldo: " + this.getSaldo());
        if (this.isStatus()) {
            System.out.println("\nStatus: Ativa");
        } else {
            System.out.println("\nStatus: Inativa");
        }
    }

    public void abrirConta(String tipo, String nome, float quantia) {
        double numero = Math.random() * 100;
        double valorAleatorio = Math.round(numero);
        Integer conta = (int) valorAleatorio;
        float saldoConta;
        if (quantia >= 0) {
            if (tipo.equals("CC")) {
                saldoConta = 50 + quantia;
                conta(conta, tipo, nome, saldoConta, true);
            } else if (tipo.equals("CP")) {
                saldoConta = 150 + quantia;
                conta(conta, tipo, nome, saldoConta, true);
            } else {
                System.out.println("\nTipo de conta inválida\nInforme CC para conta corrente\nInforme CP para conta poupança");
            }
        } else {
            System.out.println("Quantia informada é inválida");
        }

    }

    public void fecharConta() {
        if (getSaldo() != 0) {
            System.out.println("\nImpossível fechar esta conta\n regularize o saldo antes");
        } else {
            setStatus(false);
            System.out.println("\nConta fechada com sucesso!");
        }
    }

    public void depositar(float quantia) {
        if (status == false) {
            System.out.println("\nEsta conta está inativa \nnão foi possível fazer o depósito");
        } else if (quantia > 0) {
            float saldo = getSaldo();
            saldo += quantia;
            setSaldo(saldo);
            System.out.println("\nDepósito efetuado com sucesso!");
        } else {
            System.out.println("\nQuantia informada é inválida");
        }
    }

    public void sacar(float quantia) {
        if (status == true) {
            if (quantia <= 0) {
                System.out.println("\nValor informado é incorreto");
            } else if (quantia > getSaldo()) {
                System.out.println("\nSaldo insuficiente");
            } else {
                float saldo = getSaldo();
                saldo -= quantia;
                System.out.println("\nSaque efetuado com sucesso");
            }
        } else {
            System.out.println("\nConta desativada");
        }
    }

    public void pagarMensal() {
        float saldo = getSaldo();
        if (getTipo().equals("CC")) {
            saldo -= 12;
            setSaldo(saldo);
            System.out.println("\nPagamento de mensalidade efetuado");
        } else if (getTipo().equals("CP")) {
            saldo -= 20;
            setSaldo(saldo);
            System.out.println("\nPagamento de mensalidade efetuado");
        } else {
            System.out.println("\nERRO ao pagar mensalidade");
        }
    }

   

    //métodos especiais
    public Conta() {
        setSaldo(0);
        setStatus(false);
    }

    private void conta(Integer numConta, String tipo, String nomeTitular, float saldo, boolean status) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.status = status;
    }

    private Integer getNumConta() {
        return numConta;
    }

    private void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    private String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String getNomeTitular() {
        return nomeTitular;
    }

    private void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    private float getSaldo() {
        return saldo;
    }

    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private boolean isStatus() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }
}
