
public class RoundRobin {

    private int[] TrocarPosicoes(int[] array) {
        int fim = array.length - 1;
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            array[i] = array[i + (--fim)];
            array[i + fim] = x;
        }

        return array;
    }

    private void Imprimir(int[] array) {
        int j = array.length - 1;
        int meio = ((array.length / 2));

        for (int i = 0; i < meio; i++) {
            System.out.println(array[i] + " VS " + array[j--]);
        }

        System.out.println();
    }

    public void main(String[] args) {
        int[] array = {1, 2, 3};

        for (int i = 0; i < array.length - 1; i++) {
            Imprimir(array);
            TrocarPosicoes(array);
        }
        if (array.length == 3) {
            System.out.println(array[array.length - 1] + " VS " + array[array.length - 2]);
        }
    }
}
