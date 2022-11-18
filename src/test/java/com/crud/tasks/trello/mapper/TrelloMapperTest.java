package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardTest(){
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("Test name", "Test surname", new ArrayList<>()));
        trelloBoardDtos.add(new TrelloBoardDto("Test name2", "Test surname2", new ArrayList<>()));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoard(trelloBoardDtos);
        //Then
        assertEquals(2, trelloBoards.size());
    }

    @Test
    public void mapToBoardDtoTest(){
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("Test name", "Test surname", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("Test name2", "Test surname2", new ArrayList<>()));
        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardDto(trelloBoards);
        //Then
        assertEquals(2, trelloBoardDtos.size());
    }
    @Test
    public void mapToListTest(){
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1","test1", true));
        trelloListDtos.add(new TrelloListDto("2","test2", true));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertEquals(2, trelloLists.size());
    }
    @Test
    public void mapToListDtoTest(){
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1","test1", true));
        trelloLists.add(new TrelloList("2","test2", true));

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(2, trelloListDtos.size());
    }

    @Test
    public void mapToCardTest(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test name", "test desc", "Test pos", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
    }
    @Test
    public void mapToCardDtoTest(){
        //Given
        TrelloCard trelloCard = new TrelloCard("Test name", "test desc", "Test pos", "1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
    }

}
