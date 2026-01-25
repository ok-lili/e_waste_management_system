import React from 'react';

function AssetForm({
    asset,
    categories,
    onChange,
    onSubmit,
    onCancel,
    isEditMode
}) {
    return (
        <div style={{ marginBottom: '20px' }}>
            <h2>{isEditMode ? 'Edit Asset' : 'Add Asset'}</h2>

            <form onSubmit={onSubmit}>
                <div>
                    <label>Asset Name:</label><br />
                    <input
                        type="text"
                        name="assetName"
                        value={asset.assetName || ''}
                        onChange={onChange}
                        required
                    />
                </div>

                <div>
                    <label>Purchase Date:</label><br />
                    <input
                        type="date"
                        name="purchaseDate"
                        value={asset.purchaseDate || ''}
                        onChange={onChange}
                        required
                    />
                </div>

                <div>
                    <label>Category:</label><br />
                    <select
                        name="categoryId"
                        value={asset.categoryId || ''}
                        onChange={onChange}
                        required
                    >
                        <option value="">Select Category</option>
                        {categories.map(cat => (
                            <option key={cat.categoryId} value={cat.categoryId}>
                                {cat.categoryName}
                            </option>
                        ))}
                    </select>
                </div>

                <div>
                    <label>
                        <input
                            type="checkbox"
                            name="isEwaste"
                            checked={asset.status === 'DAMAGED'}
                            onChange={onChange}
                        />
                        {' '}Mark as E-Waste
                    </label>
                </div>

                <div style={{ marginTop: '10px' }}>
                    <button type="submit">
                        {isEditMode ? 'Update' : 'Add'}
                    </button>

                    <button
                        type="button"
                        onClick={onCancel}
                        style={{ marginLeft: '10px' }}
                    >
                        Cancel
                    </button>
                </div>
            </form>
        </div>
    );
}

export default AssetForm;
