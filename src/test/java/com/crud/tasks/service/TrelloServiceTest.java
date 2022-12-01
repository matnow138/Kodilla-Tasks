/* package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrelloServiceTest {

    @Mock
    private TrelloService trelloService;
    @Mock
    private TrelloClient trelloClient;

    @Test
    public void createTrelloCardTest(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test pos", "test listid");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1","test","url");
        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        //When
        CreatedTrelloCardDto createdTrelloCardDtoNew = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals(createdTrelloCardDtoNew.getName(), trelloCardDto.getName());
    }

    @Test
    public void fetchTrelloBoardsTest(){
        //Given
        List<TrelloListDto> trelloLists =
                List.of(new TrelloListDto("1", "test_list", false));
        List<TrelloBoardDto> trelloBoards =
                List.of(new TrelloBoardDto("test", "1", trelloLists));
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoards);

        //When
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();
        //Then
        assertThat(fetchedBoards).isNotNull();


    }
}

 */
