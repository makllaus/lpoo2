/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabanco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tone
 */
public class ContaBanco {

    public static void menu() {
        System.out.println("\n\t######## = MENU = #######");
        System.out.println("\n\t0 - SAIR              ###");
        System.out.println("\n\t1 - Abrir Conta       ###");
        System.out.println("\n\t2 - Fechar Conta      ###");
        System.out.println("\n\t3 - Depositar         ###");
        System.out.println("\n\t4 - Sacar             ###");
        System.out.println("\n\t5 - Pagar Mensalidade ###");
        System.out.println("\n\t6 - Listar Contas     ###");
        System.out.println("\n\t#########################");
    }

    //public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op, numConta;
        float quantia;
        String tipo, nome;

        ArrayList<Conta> contas = new ArrayList();

        do {
            menu();
            op = scan.nextInt();
            switch (op) {
                case 1:
                    Conta p = new Conta();

                    System.out.println("\n\tInforme o nome do Titular");
                    nome = scan.next();

                    System.out.println("\n\tInforme o tipo da conta. CC ou CP");
                    tipo = scan.next();

                    System.out.println("\n\tInforme o valor inicial para abertura");
                    quantia = scan.nextFloat();

                    p.abrirConta(tipo, nome, quantia);
                    contas.add(p);
                    break;
                case 2:
                    System.out.println("\n\tInforme o numero da conta");
                    numConta = scan.nextInt();
                    for (int i = 0; i < contas.size(); i++) {
                        Conta contaAux = contas.get(i);
                        if (contaAux.numConta == numConta) {
                            contas.get(i).fecharConta();
                        }else {
                            System.out.println("Conta inválida");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n\tInforme o numero da conta");
                    numConta = scan.nextInt();
                    System.out.println("\n\tInforme a quantia a depositar");
                    quantia = scan.nextInt();
                    for (int i = 0; i < contas.size(); i++) {
                        Conta contaAux = contas.get(i);
                        if (contaAux.numConta == numConta) {
                            contas.get(i).depositar(quantia);
                        } else {
                            System.out.println("Conta inválida");
                        }
                    }

                    break;
                case 4:
                    System.out.println("\n\tInforme o numero da conta");
                    numConta = scan.nextInt();
                    System.out.println("\n\tInforme a quantia a sacar");
                    quantia = scan.nextInt();
                    for (int i = 0; i < contas.size(); i++) {
                        Conta contaAux = contas.get(i);
                        if (contaAux.numConta == numConta) {
                            contas.get(i).fecharConta();
                        }else {
                            System.out.println("Conta inválida");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n\tInforme o numero da conta");
                    numConta = scan.nextInt();
                    for (int i = 0; i < contas.size(); i++) {
                        Conta contaAux = contas.get(i);
                        if (contaAux.numConta == numConta) {
                            contas.get(i).pagarMensal();
                        }else {
                            System.out.println("Conta inválida");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n==============================");
                    for (int i = 0; i < contas.size(); i++) {
                        Conta contaAux = contas.get(i);
                        contaAux.status();
                        System.out.println("\n==============================");
                    }
                case 0:
                    break;
                default:
                    break;

            }

        } while (op != 0);

    }
}
