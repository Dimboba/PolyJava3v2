package test;

import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.GameLauncher;
import laz.dimboba.polyjava3v2.model.game.GameMode;
import laz.dimboba.polyjava3v2.model.game.GameModel;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class GameModelTest{

    @Test
    public void testForPairs1() throws Exception{
        GameLauncher gameLauncher = new GameLauncher();

        int size = 2;
        gameLauncher.createNewGame(GameMode.Colour, size);
        GameModel model = gameLauncher.getModel();



        HashSet<Cell> cells = new HashSet<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells.add(model.getCell(i, j));
            }
        }

        assertEquals(cells.size(), size*size);

        for(Cell cell1: cells){
            int pairCount = 0;
            int pairNumber = cell1.getNumOfPair();
            for(Cell cell2: cells){
                if(cell2.getNumOfPair() == pairNumber && cell2 != cell1){
                    pairCount++;
                }
            }
            assertEquals(pairCount,1);
        }
    }
    @Test
    public void testForPairs2() throws Exception{
        GameLauncher gameLauncher = new GameLauncher();

        int size = 4;
        gameLauncher.createNewGame(GameMode.Sound, size);
        GameModel model = gameLauncher.getModel();


        HashSet<Cell> cells = new HashSet<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells.add(model.getCell(i, j));
            }
        }

        assertEquals(cells.size(), size*size);

        for(Cell cell1: cells){
            int pairCount = 0;
            int pairNumber = cell1.getNumOfPair();
            for(Cell cell2: cells){
                if(cell2.getNumOfPair() == pairNumber && cell2 != cell1){
                    pairCount++;
                }
            }
            assertEquals(pairCount,1);
        }
    }
    @Test
    public void testForEndGame() throws Exception{
        GameLauncher gameLauncher = new GameLauncher();

        int size = 2;
        gameLauncher.createNewGame(GameMode.Colour, size);
        GameModel model = gameLauncher.getModel();

        Cell cell1 = model.getCell(0, 0);
        Cell cell1pair = model.getCell(0, 0).getPairCell();

        Cell cell2;
        Cell cell2pair;
        if(model.getCell(0, 1) == cell1pair){
            cell2 = model.getCell(1, 1);
        } else {
            cell2 = model.getCell(0, 1);
        }
        cell2pair = cell2.getPairCell();

        model.makeTurn(cell1);
        assertTrue(model.isGameIsOn());

        model.makeTurn(cell1pair);
        assertTrue(model.isGameIsOn());

        model.makeTurn(cell2);
        assertTrue(model.isGameIsOn());

        model.makeTurn(cell2pair);
        assertFalse(model.isGameIsOn());
    }
}
