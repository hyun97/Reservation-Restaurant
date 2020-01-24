package com.project.reservation.interfaces;

import com.project.reservation.application.ReviewService;
import com.project.reservation.domain.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReviewController.class)
class ReviewControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void list() throws Exception {
        List<Review> reviews = new ArrayList<>();
        reviews.add(Review.builder().description("Cool!").build());

        given(reviewService.getReviews()).willReturn(reviews);

        mvc.perform(get("/reviews"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Cool!")));
    }
}