package com.stu.luanvan.service.file;

import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.request.FileRequest;

import java.util.Collection;
import java.util.Map;

public class FileService implements FileServiceInterface{
    @Override
    public Map<String, Object> findByAll(int page, int size, String nameSort) {
        return null;
    }

    @Override
    public Collection<FileModel> findByAll() {
        return null;
    }

    @Override
    public FileModel findById(Integer id) {
        return null;
    }

    @Override
    public FileModel saveNew(FileRequest fileRequest) throws Exception {
        return null;
    }

    @Override
    public FileModel saveEdit(FileRequest fileRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
