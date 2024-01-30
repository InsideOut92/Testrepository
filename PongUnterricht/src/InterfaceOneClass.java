public class InterfaceOneClass implements interfaceOne, interfaceTwo{
    public InterfaceOneClass() {
    }

    @Override
    public void hello() {
        System.out.println("Hello " + bliblablub);
    }

    @Override
    public void world() {
        System.out.println("World! " + interfaceOne.halo);
    }

    @Override
    public void tralala() {
        System.out.println("Hollywood liegt in LA");
    }

    @Override
    public void lalaland() {
        System.out.println("LA ist ein gutes Stück von uns weg.");
    }

    @Override
    public int returnInt() {
        return 0;
    }

    @Override
    public double calculateSomething(int quadrat, double schulden, double zinsen) {
        return 0;
    }
}
