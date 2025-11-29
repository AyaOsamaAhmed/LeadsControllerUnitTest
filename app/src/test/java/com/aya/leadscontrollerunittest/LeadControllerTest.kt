package com.aya.leadscontrollerunittest

import junit.framework.Assert.assertEquals
import org.junit.Test

class LeadControllerTest {

    @Test
    fun `Given valid lead when call addLoad() then we should expect lead list has on item`(){
        val lead = Lead("Aya","Osama", "01001059357")
        val controller = LeadsController()
        controller.addLead(lead)

        assertEquals(1, controller.getLeads().size)

    }


}