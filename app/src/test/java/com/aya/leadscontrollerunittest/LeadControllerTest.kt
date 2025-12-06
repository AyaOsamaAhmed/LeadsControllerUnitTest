package com.aya.leadscontrollerunittest

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import kotlin.jvm.Throws


// Rule **
// Rules allow very flexible addition or redefinition of the behavior of each test method in a test class.
// Testers can reuse or extend one of the provided Rules below, or write their own.
// https://github.com/junit-team/junit4/wiki/Rules

/*suite **
 collect some classes for testing together
 https://github.com/junit-team/junit4/wiki/Aggregating-tests-in-suites
 @RunWith(Suite.class)
@Suite.SuiteClasses({
  TestFeatureLogin.class,
  TestFeatureLogout.class,
  TestFeatureNavigate.class,
})
**/

/*Parameterized-tests
* The custom runner Parameterized implements parameterized tests. When running a parameterized test class, instances are created for the cross-product of the test methods and the test data elements.
* https://github.com/junit-team/junit4/wiki/Parameterized-tests
*
*
* */

class LeadControllerTest {

    private var controller : LeadsController? = null



    @Before  // call before each test   VS.  @BeforeClass  // call only once before all tests
    fun setup(){
        controller = LeadsController()
        print("setup ..... called")
    }
    @Test
    fun `Given valid lead when call addLoad() then we should expect lead list has on item`(){
        val lead = Lead("Aya","Osama", "01001059357")

        controller?.addLead(lead)

        assertEquals(1, controller?.getLeads()?.size)

    }

    @Test
    fun `Given lead with two char in first name when call addLoad() then we should expect that lead is empty`(){
        val lead = Lead("AA","Osama", "01001059357")
        controller?.addLead(lead)

        assertTrue(controller?.getLeads()?.isEmpty() == true)

    }

    @Test
    fun `Given lead with two char in last name when call addLoad() then we should expect that lead is empty`(){
        val lead = Lead("Aya","Os", "01001059357")
        controller?.addLead(lead)

        assertTrue(controller?.getLeads()?.isEmpty() == true)

    }

    @Test
    fun `Given lead with not vaild phone number when call addLoad() then we should expect that lead is empty`(){
        val lead = Lead("Aya","Osama", "0100105")
        controller?.addLead(lead)

        assertTrue(controller?.getLeads()?.isEmpty() == true)

    }

    @Test
    fun `Given lead with not vaild phone number with 12 when call addLoad() then we should expect that lead is empty`(){
        val lead = Lead("Aya","Osama", "010010593577")
        controller?.addLead(lead)

        assertTrue(controller?.getLeads()?.isEmpty() == true)

    }


    @Test(expected = IllegalArgumentException::class)
    fun `Given lead with   phone number with 11 chars when call addLoad() then we should expect that lead is empty`(){
        val lead = Lead("Aya","Osama", "AAAAAAAAAAA")
        controller?.addLead(lead)

        assertTrue(controller?.getLeads()?.isEmpty() == true)

    }


    @Ignore("ignore this test")
    @Test
    fun `Given lead with  vaild phone number when call addLoad() then we should expect that lead is non empty`(){
        val lead = Lead("Aya","Osama", "01001059357")
        controller?.addLead(lead)

        assertEquals(1,controller?.getLeads()?.size )

    }

    @Test
    fun `Given lead with  duplicated load when call addLoad() then we should expect that lead is non empty`(){
        val lead = Lead("Aya","Osama", "01001059357")
        controller?.addLead(lead)
        controller?.addLead(lead)

        assertEquals(1,controller?.getLeads()?.size )

    }

    @After
    fun tearDown() {
        controller = null
        print("tearDown ..... called")
    }
}