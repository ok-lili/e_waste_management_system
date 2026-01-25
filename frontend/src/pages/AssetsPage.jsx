// assetList + assetForm , to decide user's role

import React, { useEffect, useState } from "react";
import AssetService from "../api/AssetService";
import CategoriesService from "../api/CategoryService";
import AssetForm from "../components/AssetForm";
import AssetList from "../components/AssetList";

const AssetsPage = () => {
    const [assets, setAssets] = useState([]);
    const [categories, setCategories] = useState([]);
    const [isEditMode, setIsEditMode] = useState(false);
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);
    const [selectedAsset, setSelectedAsset] = useState(null);

    const role = localStorage.getItem("role");
    const isAdmin = role === "ADMIN";

    const fetchAssets = async () => {
        try {
            setLoading(true);
            const res = await AssetService.getAllAssets();
            console.log("Fetched assets:", res.data);
            setAssets(res.data);
        } catch (err) {
            setError("failed to load assets");
        } finally {
            setLoading(false);
        }
    };

    const fetchCategories = async () => {
        try {
            setLoading(true);
            const res = await CategoriesService.getCateogories();
            setCategories(res.data);
        } catch (err) {
            setError("failed to get categories");
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchAssets();
        fetchCategories();
    }, []);

    // add/update
    const handleSubmit = async (asset) => {
        e.preventDefault();
        try {
            if (isEditMode) {
                await AssetService.updateAsset(asset.assetId, asset);
            } else {
                await AssetService.createAsset(asset);
            }
            fetchAssets(); //refresh list after save
            setSelectedAsset(null);
            setIsEditMode(false);
        } catch (err) {
            setError("save failed");
        }
    };
    const handleEdit = async (asset) => {
        setSelectedAsset(asset);
        setIsEditMode(true);
    };

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;

        setSelectedAsset(prev => ({
            ...prev,
            [name]: type === "checkbox" ? (checked ? "DAMAGED" : "ACTIVE") : value
        }));
    };
    const handleDelete = async (id) => {
        await AssetService.deleteAsset(id);
        fetchAssets();
    };


    return (
        <div>
            {isAdmin && (
                <AssetForm
                    asset={selectedAsset || {}} //means if selectedAsset hai to use that nahi to empty obj send krow 
                    categories={categories}
                    isEditMode={isEditMode}
                    onSubmit={handleSubmit}
                    onCancel={() => {
                        setSelectedAsset(null);
                        setIsEditMode(null);
                    }
                    }
                />
            )}

            <AssetList
                assets={assets}
                loading={loading}
                error={error}
                role={role}
                onEdit={handleEdit}
                onDelete={handleDelete}
            />
        </div>
    );
};

export default AssetsPage;
