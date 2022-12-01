package com.example.wellbeing.repository

import com.example.wellbeing.database.StepDAO
import com.example.wellbeing.model.Step
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StepRepository @Inject constructor(private val stepDAO: StepDAO) {
    suspend fun getStep(date:String): Flow<Step> {
        if(!stepDAO.isDateExist(date)) {
            stepDAO.insertStep(step = Step(0,0,0,0,date))
        }
        return stepDAO.getStep(date)
    }

    suspend fun updateStep(step: Step){
        if(!stepDAO.isDateExist(step.date)) {
            stepDAO.insertStep(step = step)
        }
        else {
            stepDAO.updateStep(step.date, step.step_calories,step.time,step.distance)
        }
    }
}