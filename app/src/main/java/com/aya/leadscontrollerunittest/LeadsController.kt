package com.aya.leadscontrollerunittest

class LeadsController {

    private var leadsList = mutableListOf<Lead>()

    fun addLead(lead: Lead) {
        leadsList.add(lead)
    }

    fun getLeads() : List<Lead> {
        return leadsList

    }


}
