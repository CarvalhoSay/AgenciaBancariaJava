package Programa;

import utilitarios.Util;

public class Conta {
    private static int contadorDeConta = 1;

    private int numeroConta;
    private Cliente pessoa;
    private Double saldo = 0.0;

    public Conta(Cliente pessoa) {
        this.numeroConta = contadorDeConta;
        this.pessoa = pessoa;
        contadorDeConta = 1;

    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getPessoa() {
        return pessoa;
    }

    public void setPessoa(Cliente pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNumero da Conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCPF() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Util.doubleToString(getSaldo()) +
                "\n";
    }
    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com Sucesso!");
        } else {
            System.out.println("Não foi possivel realizar o deposito!");
        }
    }

    public void sacar (Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar o saque ");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);


            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia Realizada com sucesso");
        } else {
            System.out.println("Não foi possivel realizar a transferencia");
        }

    }

}
