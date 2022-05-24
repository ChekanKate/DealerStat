package com.chekan.leverX;

import com.chekan.leverX.entity.Game;
import com.chekan.leverX.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@Component
public class GameServiceTest {

    @Autowired
    GameService mockGameService;

    @Test
    public void testGetByIdGame() {
        Game game = new Game(102, "Fifa");
        Game result = mockGameService.getGameById(102);
        assertEquals(game, result);
    }

}
