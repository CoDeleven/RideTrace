package com.studio701.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.studio701.user.GenKt.createUser;
import static com.studio701.user.RequestBuilderKt.get;
import static com.studio701.user.RequestBuilderKt.post;
import static com.studio701.user.RequestBuilderKt.put;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreated() {
		post("/user/", mockMvc, createUser());
	}

    @Test
    public void testQuery() {
        System.out.println(get("/user/admin", mockMvc, null));
    }

    @Test
	public void testFavoriteRouteBook(){
		System.out.println(get("/user/admin/favorite/route-book", mockMvc, null));
	}

	@Test
	public void testMyRouteBook(){
		System.out.println(get("/user/admin/my/route-book", mockMvc, null));
	}

	@Test
	public void insertRouteBOok(){
		put("/user/admin/favorite/5a90c377a94b59ca0c39fba8", mockMvc, null);
	}
}
