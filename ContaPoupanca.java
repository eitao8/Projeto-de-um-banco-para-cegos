package Bancasso;

import java.util.Scanner;

public class ContaPoupanca {
	private String nome;
	private static double saldo_poupanca;
        Scanner sc = new Scanner(System.in);
	
	public ContaPoupanca(String nome, double saldo_poupanca) {
		this.setNome(nome);
		ContaPoupanca.setSaldo_poupanca(saldo_poupanca);
	}
		
	//Funcao para saque
	public static double saque(double saldo_corrente) {
		if(saldo_corrente > 0) {
                    double valor;
			valor = ContaCorrente.valor;
			if(valor > saldo_corrente) {
                System.out.println("Saldo Insuficiente na Conta Poupanca");
                return saldo_corrente;
			}else if(valor < 0){
				System.out.println("Impossivel Saque Negativo");
				return saldo_corrente;
			} else {
                saldo_corrente = saldo_corrente - valor;
                ContaCorrente.transacoes.add("Saque: -" + valor);
                return saldo_corrente;                   
			}
		}else {
			//Menssagem de NÃo possui saldo
                        //System.out.println("Saldo Zerado na Conta Poupanca");
			return saldo_corrente;
		}
	}

	//Funcao para deposito
	public static double deposito(double saldo_corrente) {
		double valor;
                valor = ContaCorrente.valor;
		saldo_corrente = saldo_corrente + valor;
		//transacoes.add("Deposito: +" + valor);
		return saldo_corrente;
	}
		
	//Função para exibir o saldo da conta poupanca
	public static void saldo() {
            Banco_Frame.play("saldoInformacao");
            System.out.println("Saldo Poupanca: " + ContaPoupanca.getSaldo_poupanca());
	}

		public String getNome() {
			return nome;
		}

		public final void setNome(String nome) {
			this.nome = nome;
		}

		public static double getSaldo_poupanca() {
			return saldo_poupanca;
		}

		public static void setSaldo_poupanca(double saldo_poupanca) {
			ContaPoupanca.saldo_poupanca = saldo_poupanca;
		}
	}
