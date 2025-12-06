package com.aya.leadscontrollerunittest

class LeadsController {


    //testing on public function only

    private var leadsList = mutableSetOf<Lead>()

    fun addLead(lead: Lead) {
        if(isValidInput(lead.firstName) && isValidInput(lead.lastName) && isValidPhoneNumber(lead.phoneNumber))
        leadsList.add(lead)
    }

    fun getLeads() : Set<Lead> {
        return leadsList

    }

    private fun isValidInput(input : String): Boolean{
        return input.length >= 3
    }

    private fun isValidPhoneNumber(input : String): Boolean{
        if(input.all { char -> char.isLetter() })
            throw IllegalArgumentException("Phone number can't contain letters")

        return input.length == 11 && input.all { char -> char.isDigit() }
    }

}
