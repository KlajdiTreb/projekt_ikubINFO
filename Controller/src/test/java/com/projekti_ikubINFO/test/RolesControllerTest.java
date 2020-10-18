package com.projekti_ikubINFO.test;

import com.projekti_ikubINFO.entity.Roles;
import com.projekti_ikubINFO.repository.RolesRepository;
import com.projekti_ikubINFO.services.RolesServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RolesControllerTest {

    @Autowired
    private RolesServices rolesServices;

    @MockBean
    private RolesRepository rolesRepository;

    @Autowired
    private WebApplicationContext wac;
    private  MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void showAllRolesTest() {
        when(rolesRepository.findAll()).thenReturn(
                Stream.of(new Roles(5, "MANAGEMENT"), new Roles(6, "CEO")).collect(Collectors.toList()));

        assertEquals(2, rolesServices.showAllRoles().size());
    }

    @Test
    public void saveUserTest() {
        Roles roles = new Roles(3, "MANAGEMENT");
        when(rolesRepository.save(roles)).thenReturn(roles);
        assertEquals(roles, rolesServices.addRoles(roles));
    }


    //@Test
    //public void deleteRolesTest() throws ResourceNotFoundException {
    //    Roles roles = new Roles(2, "BOSS");
    //    rolesServices.deleteRolesById(roles.getId_role());
    //    verify(rolesRepository, times(1)).delete(roles);
    //}

}
