package banco;
class Conta {

    private Integer saldo = 0;
    private Cliente titular;

    public void setTitular(Cliente titular){
        this.titular = titular;
    }
    public Double consultarSaldo(){
        return saldo.doubleValue() / 100;
    }
    public String consultarTitular(){
        return titular.getNome();
    }

    public void depositar(Double valor){
        Double valorEmCentavos = valor * 100; // convertendo o valor em centavos
        this.saldo += valorEmCentavos.intValue();
    }
    public void sacar(Double valor){
        Double valorEmCentavos = valor * 100;
        Integer valorInteiro = valorEmCentavos.intValue();
        if(valorInteiro <= this.saldo){
            this.saldo -= valorInteiro;
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void parcelarCompra(Double valorCompra, Integer qtdeParcelas) {
        valorCompra *= 100;
        Integer valorCompraEmCentavos = valorCompra.intValue();
        Integer valorParcela = valorCompraEmCentavos / qtdeParcelas;
        Integer acrescimoPrimeiraParcela = valorCompraEmCentavos % qtdeParcelas;
        
        for (int i = 1; i <= qtdeParcelas; i++) {
            Integer valorPagar = valorParcela;
            if (i == 1) {
                valorPagar += acrescimoPrimeiraParcela;
            }
            System.out.printf("Valor a pagar na %dº parcela é de %.2f\n", i, valorPagar.doubleValue() / 100);
        }
    }

    public void parcelaCompra(double v, int i) {

    }

    public void setTitutar(Cliente cliente) {
    }
}
