package com.org.air.asia;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.org.air.asia.model.Hotels;
import com.org.air.asia.service.HotelServices;

@SpringBootTest
@RunWith(SpringRunner.class)
class AirAsiaHotelManagementSystemApplicationTests {

	@Autowired
	   private MockMvc mvc;
	
	 @MockBean
	   private HotelServices hotelServices;
	
	@Test
	public void testTofindHotelinfo() throws Exception {
		when(hotelServices.getAll()).thenReturn((List<Hotels>) status().isOk());
		
		mvc.perform(get("/app2/getAllRegisteredHotels"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
	}
	
	@Test
    public void findByHotelnameNotFound_ShouldReturnHttpStatusCode404() throws Exception {
        when(hotelServices.getByhotelName("xyzHotel")).thenThrow(new Exception("Not Found"));
 
        mvc.perform(get("/app2/getHotelInfoByName", "xyz"))
                .andExpect(status().isNotFound());
 
        verify(hotelServices, times(1)).getByhotelName("xyz");
        verifyNoMoreInteractions(hotelServices);
    }

}
