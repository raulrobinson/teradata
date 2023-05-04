package co.com.telefoncia.ws.service;

import co.com.telefoncia.ws.dto.RequestDTO;

public interface TeradataService {
    Object getCustomQueryByRequestParam(String query);
    Object getCustomQueryByRequestBody(RequestDTO requestDTO);
}
