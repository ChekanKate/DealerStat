package com.chekan.leverX;

import com.chekan.leverX.controller.GameController;
import com.chekan.leverX.entity.Game;
import com.chekan.leverX.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    GameService mockGameService;

    @InjectMocks
    GameController gameController = new GameController();

    @Test
    public void testAddGame() {
        Game game = new Game("Test Game");
        Game result = gameController.addNewGame(game);
        assertEquals(game, result);
    }

}
