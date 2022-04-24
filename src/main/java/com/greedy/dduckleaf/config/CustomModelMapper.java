package com.greedy.dduckleaf.config;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

/**
 * <pre>
 * Class : CustomModelMapper
 * Comment : ModelMapper는 기본적으로 source class가 null인 경우 exception을 발생 시키는데,
 *           Source Object가 null인 경우 ModelMapper의 map 메소드를 override 해서
 *           변환하고자 하는 엔티티 객체를 기본 오브젝트로 생성할 수 있도록 처리하였습니다.
 *
 * History
 * 2022-04-24 클래스 생성 및 map 메소드를 오버라이딩하여 재정의
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public class CustomModelMapper extends ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType) {

        Object targetSource = source;

        if(source == null) {
            targetSource = new Object();      //기본생성자로 생성 처리
        }

        return super.map(targetSource, destinationType);
    }
}
