package carros;

public class MinhaThreads implements Runnable{
    
    private String nome;
    private boolean suspensa;
    private boolean terminada;
    public MinhaThreads(String nome){
        this.nome = nome;
        this.suspensa = false;
        new Thread(this, nome).start();
    }
    
    @Override
    public void run() {
        System.out.println("Executando "+this.nome);
        
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread "+this.nome+", "+i);
                Thread.sleep(300);
                synchronized (this){
                    while (suspensa){
                        wait();
                    }
                    if (this.terminada) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread "+this.nome+" terminada.");
    }
    void suspend(){
        this.suspensa = true;
    }
    synchronized void resume(){
        this.suspensa = false;
        notify();
    }
    
    synchronized void stop(){
        this.terminada = true;
        notify();
    }
}
