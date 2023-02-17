package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    public Page<Board> boardSearchList(String searchKeyboard, Pageable pageable) {
        return boardRepository.findByTitleContaining(searchKeyboard, pageable);
    }

    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }
}
