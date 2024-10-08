package com.example.med_cards.mapper.patientDisease;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoCreate;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.model.Disease;
import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDiseaseMapperImpl implements PatientDiseaseMapper {
    @Override
    public PatientDiseaseDtoCreate toDtoCreate(PatientDisease patientDisease){
        if (patientDisease == null){
            return null;
        }

        return PatientDiseaseMapper.INSTANCE.toDtoCreate(patientDisease);
    }

    @Override
    public PatientDisease toModelCreate(PatientDiseaseDtoCreate patientDiseaseDtoCreate) {
        if (patientDiseaseDtoCreate == null){
            return null;
        }
        return PatientDiseaseMapper.INSTANCE.toModelCreate(patientDiseaseDtoCreate);
    }

    @Override
    public PatientDiseaseDtoView toDtoView(PatientDisease patientDisease){
        if (patientDisease == null){
            return null;
        }

        return PatientDiseaseMapper.INSTANCE.toDtoView(patientDisease);
    }
    @Override
    public PatientDisease toModelView(PatientDiseaseDtoView patientDiseaseDtoView) {
        if (patientDiseaseDtoView == null){
            return null;
        }
        return PatientDiseaseMapper.INSTANCE.toModelView(patientDiseaseDtoView);
    }

    @Override
    public List<PatientDisease> toModelViewList(List<PatientDiseaseDtoView> patientDiseaseDtoList) {
        if (patientDiseaseDtoList == null){
            return null;
        }
        List<PatientDisease> patientDiseaseList = new ArrayList<>();
        for (PatientDiseaseDtoView patientDiseaseDtoView: patientDiseaseDtoList) {
            patientDiseaseList.add(PatientDiseaseMapper.INSTANCE.toModelView(patientDiseaseDtoView));
        }

        return patientDiseaseList;
    }

    @Override
    public List<PatientDiseaseDtoView> toDtoViewList(List<PatientDisease> patientDiseaseList) {
        if (patientDiseaseList == null){
            return null;
        }
        List<PatientDiseaseDtoView> patientDiseaseDtoViewList = new ArrayList<>();
        for (PatientDisease patientDisease: patientDiseaseList) {
            patientDiseaseDtoViewList.add(PatientDiseaseMapper.INSTANCE.toDtoView(patientDisease));
        }
        return patientDiseaseDtoViewList;
    }
}
