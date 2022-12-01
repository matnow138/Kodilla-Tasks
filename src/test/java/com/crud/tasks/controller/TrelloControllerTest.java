/* package com.crud.tasks.controller;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrelloControllerTest {

    @InjectMocks
    private TrelloController trelloController;
    @Mock
    private TrelloService trelloService;

    @Mock
    private TrelloValidator trelloValidator;

    @Mock
    private TrelloMapper trelloMapper;
    @Mock
    private TrelloFacade trelloFacade;

    @Test
    public void getTrelloBoardsTest(){
        //Given
        List<TrelloListDto> trelloLists =
                List.of(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoards =
                List.of(new TrelloBoardDto("test", "1", trelloLists));

        List<TrelloList> mappedTrelloLists =
                List.of(new TrelloList("1", "test_list", false));

        List<TrelloBoard> mappedTrelloBoards =
                List.of(new TrelloBoard("1", "test", mappedTrelloLists));
        //When
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoards);
        when(trelloMapper.mapToBoard(trelloBoards)).thenReturn(mappedTrelloBoards);
        when(trelloMapper.mapToBoardDto(anyList())).thenReturn(trelloBoards);
        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(mappedTrelloBoards);
        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoards);
        List<TrelloBoardDto> trelloBoardDtoList = trelloController.getTrelloBoards().getBody();
        //Then
        assertThat(trelloBoardDtoList).isNotNull();
    }
    @Test
    public void createTrelloCardTest(){
        //Given
        List<TrelloListDto> trelloLists =
                List.of(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoards =
                List.of(new TrelloBoardDto("test", "1", trelloLists));

        List<TrelloList> mappedTrelloLists =
                List.of(new TrelloList("1", "test_list", false));

        List<TrelloBoard> mappedTrelloBoards =
                List.of(new TrelloBoard("1", "test", mappedTrelloLists));
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test pos", "test listid");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1","test","url");
        //When
        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoards);
        when(trelloMapper.mapToBoard(trelloBoards)).thenReturn(mappedTrelloBoards);
        when(trelloMapper.mapToBoardDto(anyList())).thenReturn(trelloBoards);
        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(mappedTrelloBoards);
        when(trelloFacade.createCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        CreatedTrelloCardDto createdTrelloCardDto2 = trelloController.createTrelloCard(trelloCardDto).getBody();
        //Then
        assertEquals(createdTrelloCardDto2.getName(), trelloCardDto.getName());

    }


} */
