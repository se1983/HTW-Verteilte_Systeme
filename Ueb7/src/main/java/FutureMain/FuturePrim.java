package FutureMain;

import prim.Primchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Erstellt von  sebsch on 20.01.17.
 */
public class FuturePrim {

    public FuturePrim (final int threads){

        try {
            getRandumPrimsByFuture(threads)
                    .forEach(i -> System.out.println("Primzahl >>  " + i.toString()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> getRandumPrimsByFuture(final int threads)
            throws InterruptedException, ExecutionException {

        final ArrayList<Integer> solBins = new ArrayList<>(threads);

        // Prepare to execute and store the Futures
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        List<FutureTask<Integer>> taskList = new ArrayList<>();

        // Start threads
        for (int j = 0; j < threads; j++) {
            FutureTask<java.lang.Integer> futureTask = getFutureTask();
            taskList.add(futureTask);
            executor.execute(futureTask);

        }


        // Get solutions
        for (FutureTask<java.lang.Integer> task : taskList) {
            solBins.add(task.get());
        }

        executor.shutdown();
        return solBins;
    }

    private  static FutureTask<java.lang.Integer> getFutureTask() {
        System.out.println("[Info] Task initialisiert");
        final Primchecker pc = new Primchecker();

        return new FutureTask<>(pc::getRandomPrim);
    }
}





