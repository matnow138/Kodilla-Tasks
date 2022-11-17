package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;

import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.trello.config.TrelloConfig;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TrelloMapperTest {

    @Mock
    private TrelloMapper trelloMapper;



    @Test
    public void mapToBoardTest() throws URISyntaxException {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("Kodilla", "test_id", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoard(trelloBoardDtos);
        //Then
        assertEquals(trelloBoard.size(),1);
    }
}
